/*    */ package Koishi.cards.Skills.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.actions.unique.DiscardPileToTopOfDeckAction;
/*    */ import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
/*    */ 
/*    */ public class HeartfeltFancy extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(HeartfeltFancy.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("HeartfeltFancy.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int ENERGY_LOSS = 1;
/*    */   
/*    */   private static final int BLOCK = 8;
/*    */   private static final int UPGRADE_PLUS_BLOCK = 3;
/*    */   
/*    */   public HeartfeltFancy() {
/* 34 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 35 */     this.baseBlock = 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 40 */     KoishiMod.runAnimation("spellA");
/* 41 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DiscardPileToTopOfDeckAction((AbstractCreature)p));
/* 42 */     if (EnergyPanel.totalCount > 0) {
/* 43 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/*    */     }
/* 45 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new LoseEnergyAction(1));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 50 */     if (!this.upgraded) {
/* 51 */       upgradeName();
/* 52 */       upgradeBlock(3);
/* 53 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Common/HeartfeltFancy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
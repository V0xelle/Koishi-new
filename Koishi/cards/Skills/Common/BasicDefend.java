/*    */ package Koishi.cards.Skills.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import basemod.helpers.BaseModCardTags;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class BasicDefend extends AbstractDefaultCard {
/* 16 */   public static final String ID = KoishiMod.makeID(BasicDefend.class.getSimpleName());
/* 17 */   public static final String IMG = KoishiMod.makeCardPath("BasicDefend.png");
/*    */   
/* 19 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.BASIC;
/* 20 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 21 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 22 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   private static final int BLOCK = 5;
/*    */   private static final int UPGRADE_PLUS_BLOCK = 3;
/*    */   
/*    */   public BasicDefend() {
/* 29 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 30 */     this.baseBlock = 5;
/* 31 */     this.tags.add(BaseModCardTags.BASIC_DEFEND);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     KoishiMod.runAnimation("spellA");
/* 37 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 42 */     if (!this.upgraded) {
/* 43 */       upgradeName();
/* 44 */       upgradeBlock(3);
/* 45 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Common/BasicDefend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package Koishi.cards.Skills.Common;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.EphemeralPower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class PhantomBarrier extends AbstractDefaultCard {
/* 17 */   public static final String ID = KoishiMod.makeID(PhantomBarrier.class.getSimpleName());
/* 18 */   public static final String IMG = KoishiMod.makeCardPath("PhantomBarrier.png");
/*    */   
/* 20 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 21 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 22 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 23 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int BLOCK = 7;
/*    */   
/*    */   private static final int UPGRADE_PLUS_BLOCK = 3;
/*    */   private static final int BUFF = 1;
/*    */   
/*    */   public PhantomBarrier() {
/* 33 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 34 */     this.baseBlock = 7;
/* 35 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 40 */     KoishiMod.runAnimation("spellA");
/* 41 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/* 42 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EphemeralPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 47 */     if (!this.upgraded) {
/* 48 */       upgradeName();
/* 49 */       upgradeBlock(3);
/* 50 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Common/PhantomBarrier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
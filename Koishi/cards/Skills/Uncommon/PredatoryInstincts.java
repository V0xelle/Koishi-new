/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class PredatoryInstincts extends AbstractDefaultCard {
/* 19 */   public static final String ID = KoishiMod.makeID(PredatoryInstincts.class.getSimpleName());
/* 20 */   public static final String IMG = KoishiMod.makeCardPath("PredatoryInstincts.png");
/*    */   
/* 22 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 23 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ALL_ENEMY;
/* 24 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 25 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int BLOCK = 5;
/*    */   
/*    */   private static final int UPGRADE_PLUS_BLOCK = 2;
/*    */   private static final int DEBUFF = 4;
/*    */   private static final int UPGRADE_PLUS_DEBUFF = 2;
/*    */   
/*    */   public PredatoryInstincts() {
/* 36 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 37 */     this.magicNumber = this.baseMagicNumber = 4;
/* 38 */     this.baseBlock = 5;
/* 39 */     this.exhaust = true;
/* 40 */     KoishiMod.setBackground((CustomCard)this, 1);
/* 41 */     this.tags.add(AbstractCard.CardTags.HEALING);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 46 */     KoishiMod.runAnimation("occultAttack");
/* 47 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, this.block));
/* 48 */     Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 49 */     while (iterator.hasNext()) {
/* 50 */       AbstractMonster mo = iterator.next();
/* 51 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new TerrorPower((AbstractCreature)mo, (AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 58 */     return 18.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 64 */     if (!this.upgraded) {
/* 65 */       upgradeName();
/* 66 */       upgradeBlock(2);
/* 67 */       upgradeMagicNumber(2);
/* 68 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/PredatoryInstincts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */